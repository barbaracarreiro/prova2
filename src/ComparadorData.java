
    import java.util.Comparator;

public class ComparadorData implements Comparator <Venda> {
    @Override
    public int compare(Venda o1, Venda o2) {
        // TODO Auto-generated method stub
        return o1.getDataRev().compareTo(o2.getDataRev());
    }

}

