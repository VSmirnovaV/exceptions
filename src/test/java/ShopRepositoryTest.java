import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldFindProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(15, "Молоко",60);
        Product product2 = new Product(17, "Яйца",80);
        Product product3 = new Product(25,"Батон",30);


        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Product[] expected = {product1,product2,product3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(15, "Молоко",60);
        Product product2 = new Product(17, "Яйца",80);
        Product product3 = new Product(25,"Батон",30);


        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.remove(15);

        Product[] expected = {product2,product3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldDeleteNonExistentProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(15, "Молоко",60);
        Product product2 = new Product(17, "Яйца",80);
        Product product3 = new Product(25,"Батон",30);


        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(30);
        });
    }
}
