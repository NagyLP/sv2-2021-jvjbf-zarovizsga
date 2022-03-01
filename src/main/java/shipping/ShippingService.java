package shipping;

import java.util.*;
import java.util.stream.Collectors;

public class ShippingService {

    private List<Transportable> packages = new ArrayList<>();

    private static Integer pack(Transportable t) {
        return ((InternationalPackage) t).getDistance();
    }


    public void addPackage(Transportable transportable) {
        packages.add(transportable);

    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
//        List<Transportable> transportables = new ArrayList<>();
//        for (Transportable item : packages) {
//            if (item.isBreakable() == breakable && item.getWeight() >= weight) {
//                transportables.add(item);
//            }
//        }
//        return transportables;

        return packages.stream()
                .filter(pack -> pack.isBreakable() == breakable)
                .filter(pack -> pack.getWeight() >= weight)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> collectResult = new HashMap<>();
        for (Transportable item : packages) {
            collectResult.compute(
                    item.getDestinationCountry(),
                    (key, value) -> value == null ? 1 : value + 1);
        }
        return collectResult;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream()
                .filter(InternationalPackage.class::isInstance)
//                .filter(t -> t instanceof InternationalPackage)
//        (t -> ((InternationalPackage) t).getDistance()))
                .sorted(Comparator.comparing
                        (ShippingService::pack))
                .toList();
    }

    public List<Transportable> getPackages() {
        return packages;
    }
}
