package edu.tarumt.choojun.dao.impl;

import edu.tarumt.choojun.dao.ItemDao;
import edu.tarumt.choojun.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Item item) {
        String sql = "INSERT INTO items (name, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, item.getName(), item.getDescription());
    }

    @Override
    public Item getById(Long id) {
        String sql = "SELECT id, name, description FROM items WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ItemRowMapper());
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return null; // Handle the case where the item is not found
        }
    }

    @Override
    public List<Item> getAll() {
        String sql = "SELECT id, name, description FROM items";
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }

    @Override
    public void update(Item item) {
        String sql = "UPDATE items SET name = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(sql, item.getName(), item.getDescription(), item.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM items WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // RowMapper to map database rows to Item objects
    private static class ItemRowMapper implements RowMapper<Item> {
        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item item = new Item();
            item.setId(rs.getLong("id"));
            item.setName(rs.getString("name"));
            item.setDescription(rs.getString("description"));
            return item;
        }
    }
}