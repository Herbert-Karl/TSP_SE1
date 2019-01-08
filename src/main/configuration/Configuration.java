package configuration;

import random.MersenneTwisterFast;

public enum Configuration {
    instance;

    public String fileSeparator = System.getProperty("file.separator");
    public String userDirectory = System.getProperty("user.dir");

    public String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;
    public String dataFilePath = dataDirectory + "TSP280.txt";

    public String databaseFile = dataDirectory + "datastore.db";

    public MersenneTwisterFast randomGenerator = new MersenneTwisterFast(System.currentTimeMillis());

    public CrossoverType crossoverType = CrossoverType.PMX;
    public MutationType mutationType = MutationType.DM;
    double crossoverRatio = 0.7;
    double mutationRatio = 0.001;

    public int tournamentSelectionSize = 8;
}