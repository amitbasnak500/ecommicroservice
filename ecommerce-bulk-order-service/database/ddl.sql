CREATE TABLE ORDER_ITEMS
(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  QTY_ORDERED bigint(20) NOT NULL,
  UNIT_PRICE double NOT NULL,
  order_id bigint(20) NOT NULL,
  product_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY (order_id),
  KEY (product_id),
  CONSTRAINT FOREIGN KEY (product_id) REFERENCES product(id),
  CONSTRAINT FOREIGN KEY (order_id) REFERENCES ORDER (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
