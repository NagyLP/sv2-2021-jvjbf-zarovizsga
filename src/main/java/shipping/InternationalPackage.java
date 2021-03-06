package shipping;

public class InternationalPackage implements Transportable {

    private static final int INLAND_TRANS_PRICE = 1200;
    private static final int BREAKABLE_FEEiNCREASER = 2;
    private static final int INTERNATIONAL_PRICE_PER_KM = 10;


    private final int weight;
    private final boolean breakable;

    private String destinationCountry;
    private int distance;

    public InternationalPackage(
            int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }


    @Override
    public int calculateShippingPrice() {
        return breakable ?
                BREAKABLE_FEEiNCREASER * INLAND_TRANS_PRICE + (distance * INTERNATIONAL_PRICE_PER_KM)
                : INLAND_TRANS_PRICE + (distance * INTERNATIONAL_PRICE_PER_KM);
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }
}
