

import base.City;
import configuration.Configuration;
import crossover.Crossover;
import data.HSQLManagerForEvolution.HSQLManager;
import data.InstanceReader;
import data.TSPLIBReader;
import mutation.Mutation;
import selection.Selection;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Program {
    private ArrayList<City> availableCities;
    private double[][] distances;

    private Crossover crossover;
    private Selection selection;
    private Mutation mutation;

/*    public static void main(String... args) {
        Program program = new Program();
        application.startupHSQLDB();
        application.loadData();
        application.initConfiguration();
        application.execute();
        application.shutdownHSQLDB();
    }*/

    public static void main(String... args) {
        Program program = new Program();

    }

    public Program() {

        ApplicationTSP applicationTSP = new ApplicationTSP();
    }

    public void startupHSQLDB() {
        HSQLManager.tsp.startup();
    }

    //Drops all tables
    public void initHSQLDB(){
        HSQLManager.tsp.init();
    }

    public void shutdownHSQLDB() {
        HSQLManager.tsp.close();
    }

    public void printMatrix(double[][] matrix) {
        DecimalFormat decimalFormat = new DecimalFormat("000.00");

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++)
                System.out.print(decimalFormat.format(matrix[rowIndex][columnIndex]) + "\t");
            System.out.println();
        }
    }

    public void loadData() {
        System.out.println("--- GeneticAlgorithm.loadData()");
        InstanceReader instanceReader = new InstanceReader(Configuration.instance.dataFilePath);
        instanceReader.open();
        TSPLIBReader tspLibReader = new TSPLIBReader(instanceReader);

        availableCities = tspLibReader.getCities();
        System.out.println("availableCities (size) : " + availableCities.size());

        distances = tspLibReader.getDistances();

        printMatrix(distances);

        instanceReader.close();

        System.out.println();
    }

    public void initConfiguration() {
        System.out.println("--- GeneticAlgorithm.initConfiguration()");
        System.out.println();
    }

    /*public void execute() {
        System.out.println("--- GeneticAlgorithm.execute()");
        HSQLDBManager.instance.insert("hello world");
    }*/

}