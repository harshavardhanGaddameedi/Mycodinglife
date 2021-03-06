package co.uk.optum.utility;

/**
 * Created by bganesa5 on 2/15/2018.
 */
public class FeatureContext {

    private static final FeatureContext instance = new FeatureContext();
    public static String requisitionNumber;
    public static String positionName;
    public static String totalLineAmount;
    public static String purchaseOrderNumber;
    public static String businessPartner;
    public static String documentNumber;
    public static String revenueOrderNumber;
    public static String adhocNumber;



    private FeatureContext(){}

    public static FeatureContext getInstance(){
        return instance;
    }

    public static String getStoredRequisitionNumber(){
        return requisitionNumber;
    }
    public static String getAdhocNumber(){
        return adhocNumber;
    }

    public static void setAdhochNumber(String adhochNumber){
        FeatureContext.adhocNumber=adhochNumber;
    }

    public static void setRequisitionNumber(String requisitionNumber){
        FeatureContext.requisitionNumber = requisitionNumber;
    }

    public static String getStoredRevenueOrderNumber(){
        return revenueOrderNumber;
    }

    public static void setRevenueOrderNumber(String revenueOrderNumber){
        FeatureContext.revenueOrderNumber = revenueOrderNumber;
    }


    public static String getStoredDocumentNumber() {
        return documentNumber;
    }

    public static void setDocumentNumber(String documentNumber){
        FeatureContext.documentNumber = documentNumber;
    }

    public static String getPositionName(){
        return positionName;
    }

    public static void setPosistionName(String positionName){
        FeatureContext.positionName = positionName;
    }





    public static void setTotalLineAmount(String totalLineAmount){
        FeatureContext.totalLineAmount = totalLineAmount;
    }

    public static String getTotalLineAmount(){
        return totalLineAmount;
    }

    public static void setPurchaseOrderNumber(String purchaseOrderNumber){
        FeatureContext.purchaseOrderNumber = purchaseOrderNumber;
    }

    public static String getPurchaseOrderNumber(){
        return purchaseOrderNumber;
    }

    public static void setBusinessPartner(String businessPartner){
        FeatureContext.businessPartner = businessPartner;
    }

    public static String getBusinessPartner(){
        return businessPartner;
    }

}
