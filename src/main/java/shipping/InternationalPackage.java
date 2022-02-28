package shipping;

public class InternationalPackage implements Transportable {

    private static final int INLAND_TRANS_PRICE = 1200;
    private static final int BREAKABLE_PRICEiNCREASER = 2;
    private static final int INTERNATIONAL_PRICE_PER_KM = 10;


    private final int weight;
    private final boolean breakable;

    private String destinationCountry;
    private int distanceKm;

    public InternationalPackage(
            int weight, boolean breakable, String destinationCountry, int distanceKm) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distanceKm = distanceKm;
    }


    @Override
    public int calculateShippingPrice() {
        return breakable ?
                BREAKABLE_PRICEiNCREASER * INLAND_TRANS_PRICE + (distanceKm * INTERNATIONAL_PRICE_PER_KM)
                : INLAND_TRANS_PRICE + (distanceKm * INTERNATIONAL_PRICE_PER_KM);
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

    public int getDistanceKm() {
        return distanceKm;
    }
}
