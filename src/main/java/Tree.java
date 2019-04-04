import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

class Tree {

    private int value;
    private List<Tree> children = new LinkedList<>();

    public Tree(int value, List<Tree> children) {
        super();
        this.value = value;
        if (children != null) {
            this.children.addAll(children);
        }
    }

    public int getValue() {
        return value;
    }

    public List<Tree> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public Stream<Tree> flattened() {
        List<Tree> allVal = new ArrayList<Tree>();
        allVal = addVal(this, allVal);
        return allVal.stream();
    }

    private List<Tree> addVal(Tree tre, List<Tree> list){
        list.add(tre);
        if (tre.children.size()>0) {
            for( Tree tr: tre.children) {
                list = addVal(tr, list);
            }
        }
        return list;
    }

    public List<Integer> getAllValues() {
        List<Integer> allVal = new ArrayList<Integer>();
        flattened().forEach(s->allVal.add(s.value));
        return allVal;
    }

    /**
     * параметр - четный возращает все четные
     * параметр - нечетный возращает все нечетные
     */
    public List<Integer> getEvenOddValues (int EvenOdd) {
        if (EvenOdd % 2 == 0 ) {
            List<Integer> rezList = new ArrayList<Integer>();
            getAllValues().stream()
                    .filter(s -> s%2==0)
                    .forEach(d->rezList.add(d));
            return rezList;
        }
        List<Integer> rezList = new ArrayList<Integer>();
        getAllValues().stream()
                .filter(s -> s%2!=0)
                .forEach(d->rezList.add(d));
        return rezList;
    }


    public Integer sumOfEvenValues() {
        Integer rez = getEvenOddValues(2).stream().mapToInt(Integer::intValue).sum();
        return rez;
    }

    public  boolean isContains(Integer val){
        return getAllValues().stream().anyMatch(x->x==val);
    }


    @Override
    public String toString() {
        return " " + value + " ";
    }
}