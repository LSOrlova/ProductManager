import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Result;

class ProductManagerTest {
    Product book1 = new Book(3, "Crime and punishment", 300, "F.M.Dostoevsky");
    Product book2 = new Book(18, "War and peace", 500, "L.N.Tolstoy");
    Product smartphone1 = new Smartphone(67, "Samsung", 15_000, "China");
    Product smartphone2 = new Smartphone(90, "iPhone", 30_000, "USA");

    @Test
    public void testShouldAddProducts() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.getProducts();
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testShouldSearchByText() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);


        Product[] expected = {smartphone1} ;
        Product[] actual = manager.searchBy("China");
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void testShouldFindMatches() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        //manager.getProducts();

        boolean actual = manager.matches(book2, "War");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
}