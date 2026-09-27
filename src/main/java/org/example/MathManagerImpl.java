package org.example;

import org.apache.log4j.Logger;
import java.util.*;

public class MathManagerImpl implements MathManager {

    final static Logger logger = Logger.getLogger(MathManagerImpl.class);
    private static MathManagerImpl instance;

    // Estructuras de datos
    private Queue<Operacion> operacionesPendientes;
    private Map<String, List<Operacion>> operacionesPorAlumno;
    private Map<String, List<Operacion>> operacionesPorInstituto;
    private Map<String, Instituto> institutos;

    //Constructor privado
    private MathManagerImpl() {
        this.operacionesPendientes = new LinkedList<>();
        this.operacionesPorAlumno = new HashMap<>();
        this.operacionesPorInstituto = new HashMap<>();
        this.institutos = new HashMap<>();
    }

    public static MathManagerImpl getInstance() {
        if (instance == null) {
            instance = new MathManagerImpl();
        }
        return instance;
    }

    @Override
    public void requerirOperacion(String idAlumno, String idInstituto, String expresion) {
        logger.info("INICIO requerirOperacion - Alumno: " + idAlumno + ", Instituto: " + idInstituto + ", Expresion: " + expresion);

        Operacion nuevaOp = new Operacion(idAlumno, idInstituto, expresion);
        operacionesPendientes.add(nuevaOp);

        // Guardar en el historial del alumno
        operacionesPorAlumno.putIfAbsent(idAlumno, new ArrayList<>());
        operacionesPorAlumno.get(idAlumno).add(nuevaOp);

        // Guardar en el historial del instituto
        operacionesPorInstituto.putIfAbsent(idInstituto, new ArrayList<>());
        operacionesPorInstituto.get(idInstituto).add(nuevaOp);

        // Actualizar el ranking del instituto
        institutos.putIfAbsent(idInstituto, new Instituto(idInstituto));
        institutos.get(idInstituto).sumarOperacion();

        logger.info("FIN requerirOperacion - Operación añadida a la cola");
    }

    @Override
    public Operacion procesarOperacion() {
        logger.info("INICIO procesarOperacion");
        Operacion op = operacionesPendientes.poll();
        if (op != null) {
            // Calculadora polaca inversa
            ReversePolishNotation calculadora = new ReversePolishNotationImpl();
            double resultado = calculadora.process(op.getExpresion());

            op.setResultado(resultado);
            logger.info("FIN procesarOperacion - Operación calculada para " + op.getIdAlumno() + " con resultado: " + resultado);
        } else {
            logger.info("FIN procesarOperacion - Cola vacia");
        }
        return op;
    }

    @Override
    public List<Operacion> listarOperacionesInstituto(String idInstituto) {
        logger.info("INICIO listarOperacionesInstituto - Instituto: " + idInstituto);
        List<Operacion> lista = operacionesPorInstituto.getOrDefault(idInstituto, new ArrayList<>());
        logger.info("FIN listarOperacionesInstituto - Encontradas: " + lista.size());
        return lista;
    }

    @Override
    public List<Operacion> listarOperacionesAlumno(String idAlumno) {
        logger.info("INICIO listarOperacionesAlumno - Alumno: " + idAlumno);
        List<Operacion> lista = operacionesPorAlumno.getOrDefault(idAlumno, new ArrayList<>());
        logger.info("FIN listarOperacionesAlumno - Encontradas: " + lista.size());
        return lista;
    }

    @Override
    public List<Instituto> listarInstitutosOrdenados() {
        logger.info("INICIO listarInstitutosOrdenados");
        List<Instituto> listaOrdenada = new ArrayList<>(institutos.values());
        listaOrdenada.sort((i1, i2) -> Integer.compare(i2.getNumO(), i1.getNumO()));
        logger.info("FIN listarInstitutosOrdenados - Institutos ordenados: " + listaOrdenada.size());
        return listaOrdenada;
    }
}