package webshop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ProductRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemp;

    public ProductRepository(DataSource dataSource) {
        this.jdbcTemp = new JdbcTemplate(dataSource);
    }

    public long insertProduct(String productName, int price, int stock) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemp.update(con -> {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO products(product_name,price,stock) " +
                            " VALUES(?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, productName);
            stmt.setInt(2, price);
            stmt.setInt(3, stock);
            return stmt;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }


}
