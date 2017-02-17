import org.junit.Assert;
import org.junit.Test;


public class LetterInventoryTest {

    @Test
    public void constructorTest() {
        LetterInventory l = new LetterInventory();
        for(char c = 'a'; c <= 'z'; c++) {
            Assert.assertEquals(0, l.get(c));
        }
        for(char c = 'a'; c <= 'z'; c++) {
            Assert.assertEquals(0, l.get(c));
        }

        l = new LetterInventory("1235424352345^%^$#$%^&*()?>?<?><");

        l = new LetterInventory("BAna246354$)(Q#*%QnA");
        Assert.assertEquals(3, l.get('a'));
        Assert.assertEquals(1, l.get('b'));
        Assert.assertEquals(2, l.get('n'));
    }

    @Test
    public void getTest() {
        LetterInventory l = new LetterInventory("b134eebo1234pdopedee1324doowopsop");
        Assert.assertEquals(2, l.get('b'));
        Assert.assertEquals(3, l.get('d'));
        Assert.assertEquals(5, l.get('e'));
        Assert.assertEquals(6, l.get('o'));
        Assert.assertEquals(4, l.get('p'));
    }

    private void getNegativeHelper(LetterInventory l, char c) {
        try {
            l.get(c);
            Assert.fail();
        } catch(IllegalArgumentException e) {}
    }

    @Test
    public void getNegativeTest() {
        LetterInventory l = new LetterInventory();
        getNegativeHelper(l, '2');
        getNegativeHelper(l, '<');
        getNegativeHelper(l, '`');
        getNegativeHelper(l, '?');
    }

    private void setHelper(LetterInventory l, char c, int i) {
        l.set(c, 0);
        Assert.assertEquals(0, l.get(c));
        l.set(c, i);
        Assert.assertEquals(i, l.get(c));
    }
    @Test
    public void setTest() {
        LetterInventory l = new LetterInventory();
        setHelper(l, 'c', 5);
        setHelper(l, 'q', 49);
        setHelper(l, 'z', 500);
        setHelper(l, 's', 0);
    }

    private void setNegativeHelper(LetterInventory l, char c, int i) {
        try {
            l.set(c, i);
            Assert.fail();
        } catch (IllegalArgumentException e){}
    }

    @Test
    public void setNegativeTest() {
        LetterInventory l = new LetterInventory();
        setNegativeHelper(l, '3', 0);
        setNegativeHelper(l, '/', 0);
        setNegativeHelper(l, ']', 0);

        setNegativeHelper(l, 'a', -1);
        setNegativeHelper(l, 'b', -1324134);
    }

    @Test
    public void sizeTest() {
        LetterInventory l = new LetterInventory("potato");
        Assert.assertEquals(6, l.size());
        l.set('z', 40);
        Assert.assertEquals(46, l.size());
        l.set('z', 14);
        Assert.assertEquals(20, l.size());
    }


}
