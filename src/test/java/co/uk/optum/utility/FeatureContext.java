package co.uk.optum.utility;

/**
 * Created by bganesa5 on 2/15/2018.
 */
public class FeatureContext {

    private static final FeatureContext instance = new FeatureContext();
    public static String requisitionNumber; // = "900193";
    public static String totalLineAmount; // = "550";

    private FeatureContext(){}

    public static FeatureContext getInstance(){
        return instance;
    }

    public static String getStoredRequisitionNumber(){
        return requisitionNumber;
    }

    public static void setRequisitionNumber(String requisitionNumber){
        FeatureContext.requisitionNumber = requisitionNumber;
    }

    public static void setTotalLineAmount(String totalLineAmount){
        FeatureContext.totalLineAmount = totalLineAmount;
    }

    public static String getTotalLineAmount(){
        return totalLineAmount;
    }

}
