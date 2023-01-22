import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Product book1 = new Book(3, "Crime and punishment", 300, "F.M.Dostoevsky");
    Product book2 = new Book(18, "War and peace", 500, "L.N.Tolstoy");
    Product smartphone1 = new Smartphone(67, "Samsung", 15_000, "China");
    Product smartphone2 = new Smartphone(90, "iPhone", 30_000, "USA");

    @Test
    public void testSaveProduct() {
        Repository repository = new Repository();
        repository.saveProduct(book1);
        repository.saveProduct(smartphone2);
        repository.findAll();

        Product[] expected = {book1, smartphone2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveById() {
        Repository repository = new Repository();
        repository.saveProduct(book1);
        repository.saveProduct(book2);
        repository.saveProduct(smartphone1);
        repository.removeById(18);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }
}
