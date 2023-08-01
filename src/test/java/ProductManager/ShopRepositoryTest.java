package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(10, "телефон",50_000);
        Product product2 = new Product(11,"стол",10_000);
        Product product3 = new Product(12,"наушники",20_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(11);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(10, "телефон",50_000);
        Product product2 = new Product(11,"стол",10_000);
        Product product3 = new Product(12,"наушники",20_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                () ->  repo.remove(3333)
                );
    }
}