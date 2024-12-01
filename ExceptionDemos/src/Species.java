import java.io.*;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Species {
    private final String commonName;
    private final String domain;
    private final String kingdom;
    private final String phylum;
    private final String sclass;
    private final String family;
    private final String genius;
    private final String subgenius;
    private String sciSpecies;
    private long population;
    private float growthRate;

    @Override
    public String toString() {
        return "Species{" +
                "commonName='" + commonName + '\'' +
                ", domain='" + domain + '\'' +
                ", kingdom='" + kingdom + '\'' +
                ", phylum='" + phylum + '\'' +
                ", sclass='" + sclass + '\'' +
                ", family='" + family + '\'' +
                ", genius='" + genius + '\'' +
                ", subgenius='" + subgenius + '\'' +
                ", sciSpecies='" + sciSpecies + '\'' +
                ", population=" + population +
                ", growthRate=" + growthRate +
                '}';
    }

    public String getSciSpecies() {
        return sciSpecies;
    }

    public String getSubgenius() {
        return subgenius;
    }

    public String getCommonName() {
        return commonName;
    }


    public String getDomain() {
        return domain;
    }

    public String getKingdom() {
        return kingdom;
    }

    public String getPhylum() {
        return phylum;
    }

    public String getSclass() {
        return sclass;
    }

    public String getFamily() {
        return family;
    }

    public String getGenius() {
        return genius;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) throws PopulationException{
        if(population < 0) {
            throw new PopulationException();
        }
        this.population = population;
    }

    public float getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(float growthRate) throws GrowthRateException{
        if (growthRate < 0.0) {
            throw new GrowthRateException();
        }
        this.growthRate = growthRate;
    }

    public Species(String commonName, String domain, String kingdom,
                   String phylum, String sclass, String family,
                   String genius, String subgenius, String sciSpecies) throws PopulationException, GrowthRateException {
        this(commonName, domain, kingdom, phylum, sclass, family, genius, subgenius, sciSpecies, 0, 0.0f);
    }

    public Species(String commonName, String domain, String kingdom,
                   String phylum, String sclass, String family,
                   String genius, String subgenius, String sciSpecies,
                   long population, float growthRate) throws PopulationException, GrowthRateException{
        this.commonName = commonName;
        this.domain = domain;
        this.kingdom = kingdom;
        this.phylum = phylum;
        this.sclass = sclass;
        this.family = family;
        this.genius = genius;
        this.subgenius = subgenius;
        this.sciSpecies = sciSpecies;
        if (population < 0) {
            throw new PopulationException("Population may not be negative");
        }
        this.population = population;

        if (growthRate < 0) {
            throw new GrowthRateException("Growth rate may not be negative");
        }
        this.growthRate = growthRate;
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Species.class.getName());
        SortedMap<String, Species> myCollection = new TreeMap<String, Species>();
        Scanner sc = new Scanner(System.in);

        // FileNotFound and IOException are checked exceptions
        try(BufferedReader br = new BufferedReader(new FileReader("./data/species_data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                String commonName = tokens[0].replace("\"", "");
                String domain = tokens[1].replace("\"", "");;
                String kingdom = tokens[2].replace("\"", "");;
                String phylum = tokens[3].replace("\"", "");;
                String sclass = tokens[4].replace("\"", "");;
                String family = tokens[5].replace("\"", "");;
                String genius = tokens[6].replace("\"", "");;
                String subgenius = tokens[7].replace("\"", "");;
                String sciSpecies = tokens[8].replace("\"", "");;
                try {
                    Species entry = new Species(
                            commonName, domain, kingdom, phylum, sclass, family, genius, subgenius, sciSpecies
                    );
                    myCollection.put(commonName, entry);
                } catch (PopulationException p) {
                    logger.log(Level.WARNING, p.getMessage());
                    continue;
                } catch (GrowthRateException g) {
                    logger.log(Level.WARNING, g.getMessage());
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Species data file not found");
            logger.log(Level.SEVERE, "Species data file not found", e);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error reading species data file");
            logger.log(Level.SEVERE, "Error reading species data file", e);
            System.exit(2);
        }


    while (true) {
        System.out.println("Menu");
        System.out.println("1. List all species");
        System.out.println("2. List detailed information on species");
        System.out.println("3. Set population for a species");
        System.out.println("9. Exit");

        System.out.print("Choice: ");
        short choice = sc.nextShort();
        sc.nextLine(); // clear rest of line

        switch (choice) {
            case 1: listSpeciesCommonName(myCollection); break;
            case 2: System.out.print("Common name: ");
                    String nameToSearch = sc.nextLine();
                    listDetailsOnSpecies(nameToSearch, myCollection);
                    break;
            case 3: System.out.print("Common name: ");
                    String speciesNameToChange = sc.nextLine();
                    System.out.print("Population:");
                    long newPopulation = sc.nextLong(); // What if we provide a floating point value here?
                    try {
                        setPopulationForASpecies(myCollection, speciesNameToChange, newPopulation);
                    }
                    catch (PopulationException p) {
                        System.err.println(p.getMessage());
                        logger.log(Level.WARNING, p.getMessage());
                        continue;
                    }
                    break;
            case 9: System.exit(0);
            default: break;
        }
    }

    }

    private static void listSpeciesCommonName(SortedMap<String, Species> myCollection) {
        for(Species s : myCollection.values()) {
            System.out.println(s.getCommonName() + ':' + s.getSciSpecies());
        }
    }

    private static void setPopulationForASpecies(SortedMap<String, Species> myCollection, String commonName,
                                      long population) throws PopulationException {
        Species s = myCollection.get(commonName); // what if we don't find the Species object, what can we do?
        if (s != null)
            s.setPopulation(population);
    }

    private static void listDetailsOnSpecies(String commonName, SortedMap<String, Species> myCollection) {
        if(myCollection.containsKey(commonName)) {
            Species s = myCollection.get(commonName);
            System.out.println(s);
        }
        else {
            System.err.println(commonName + " not found"); // Could we convert this to an exception? How?
        }
    }

    // how we add a method to control the growth rate and handle possible exceptions?
}
