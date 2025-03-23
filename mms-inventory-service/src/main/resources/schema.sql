CREATE TABLE IF NOT EXISTS suppliers (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL UNIQUE,  -- Supplier name
    contact_name TEXT NOT NULL,  -- Contact person
    phone TEXT NOT NULL,  -- Contact number
    email TEXT UNIQUE,  -- Email (optional)
    address TEXT,  -- Supplier address
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE IF NOT EXISTS product_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS products (
    id BIGINT DEFAULT nextval('product_id_seq') PRIMARY KEY NOT NULL,
    code TEXT NOT NULL UNIQUE,  -- Unique product identifier (e.g., SKU)
    name TEXT NOT NULL,  -- Product name
    description TEXT,  -- Detailed description
    category TEXT NOT NULL,  -- Product category (e.g., 'Power Tools', 'Fasteners')
    brand TEXT,  -- Brand of the product (optional)
    supplier_id BIGINT NOT NULL,  -- References supplier table
    quantity_in_stock INT DEFAULT 0 NOT NULL,  -- Current stock level
    reorder_level INT DEFAULT 5 NOT NULL,  -- Minimum stock before reordering
    unit_price NUMERIC(10,2) NOT NULL,  -- Price per unit
    cost_price NUMERIC(10,2) NOT NULL,  -- Purchase price per unit (for profit calculations)
    image_url TEXT,  -- Product image
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Timestamp for creation
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Last update timestamp
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id) ON DELETE CASCADE
);

-- Create a trigger function for updating the `updated_at` timestamp
--CREATE OR REPLACE FUNCTION update_timestamp()
--RETURNS TRIGGER AS $$
--BEGIN
--    NEW.updated_at = CURRENT_TIMESTAMP;
--    RETURN NEW;
--END;
--$$ LANGUAGE plpgsql;
--
--CREATE TRIGGER set_timestamp
--BEFORE UPDATE ON products
--FOR EACH ROW
--EXECUTE FUNCTION update_timestamp();