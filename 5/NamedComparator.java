import java.util.Comparator;

public class NamedComparator implements Comparator<Named>{

    @Override
    public int compare(Named o1, Named o2) {
        int diff = o1.getFamilyName().compareTo(o2.getFamilyName());
        if (diff == 0) {
            diff = o1.getGivenName().compareTo(o2.getGivenName());
        }
        return diff;
    }
     
}
