public class NEmptyPList<E> extends PList<E> {
    private final E first;
    private final PList<E> rest;

    public NEmptyPList(E first, PList<E> rest) {
        this.first = first;
        this.rest = rest;
    }

    public int size() {
        return 1 + rest.size(); //1 accounts for first element
    }

    public boolean isEmpty() {
        return !(this.first instanceof Integer);
    }
    public boolean contains (E element) {
        if (first.equals(element)) {
            return true;
        } else {
            if (this.isEmpty()) {
                return false;
            }
        }

        return rest.contains(element);
    }

    public int indexOf(E element) throws NotFoundException {
        if (first.equals(element)) {
            return 0;
        }
        int indexOfElement = rest.indexOf(element);

        if (indexOfElement == -1) {
            throw new NotFoundException();
        } else {
            return 1 + indexOfElement; // +1 to account for 'first'
        }
    }

    public int lastIndexOf (E element) throws NotFoundException {
        int lastIndexOf = -1;
        try {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).equals(element)) {
                    lastIndexOf = i; //updates index variable if found.
                }
            }
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException();
        }

        if (lastIndexOf == -1) { //not found.
            throw new NotFoundException();
        } else { //found, latest index.
            return lastIndexOf;
        }

    }
    public E get (int index) throws IndexOutOfBoundsException {
        try {
            if (index == 0) {
                return first;
            }
            return rest.get(index-1); // index-1 as all indexes are shifted over 1 given 'first'

        } catch (IndexOutOfBoundsException e) { //catch out of bounds indexes.
            throw new IndexOutOfBoundsException();
        }
    }

    public PList<E> remove (int index) throws IndexOutOfBoundsException {
        try {

            if (index == 0) {
                return rest;
            }

            return new NEmptyPList<>(first,rest.remove(index-1)); //return first with new 'last'

        } catch (IndexOutOfBoundsException e) { //catch out of bounds indexes.

            throw new IndexOutOfBoundsException();
        }
    }   

    public PList<E> subList (int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        try {
            if (fromIndex > toIndex || fromIndex < 0 || toIndex > this.size()) { //backwards sublist
                throw new IndexOutOfBoundsException();
            }

            if (fromIndex == toIndex) {
                return new EmptyPList<>();
            }

            if (fromIndex == 0) {
                return new NEmptyPList<>(first,rest.subList(0,toIndex-1));
            } else {
                return rest.subList(fromIndex-1,toIndex-1);
            }

        } catch (IndexOutOfBoundsException e) {

            throw new IndexOutOfBoundsException();
        }
    }

    public boolean equals (Object other) {
        if (other instanceof NEmptyPList<?> otherList) {
            return first.equals(otherList.first) && rest.equals(otherList.rest);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return first.hashCode() + rest.hashCode();
    }
}
