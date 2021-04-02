CREATE TABLE ORDER
(
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  ORDER_NUMBER VARCHAR(50) NOT NULL,
  ORDER_TRACKING_NUMBER VARCHAR(50) NOT NULL,
  ORDER_TOTAL double NOT NULL,
  ORDER_DATE date NOT NULL,
  user_profile_id bigint(20)  NOT NULL,
  SHIPPING_ADDRESS_ID bigint(20) DEFAULT NULL,
  BILLING_ADDRESS_ID bigint(20) DEFAULT NULL,
  ACCOUNT_ID bigint(20) DEFAULT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_ORDER_SER_ID FOREIGN KEY (user_profile_id) REFERENCES user (ID),
  CONSTRAINT FK_SHIPPING_ADDRESS_ID FOREIGN KEY (SHIPPING_ADDRESS_ID) REFERENCES ADDRESS (ID),
  CONSTRAINT FK_BILLING_ADDRESS_ID FOREIGN KEY (BILLING_ADDRESS_ID) REFERENCES ADDRESS (ID),
  CONSTRAINT FK_ACCOUNT_ID FOREIGN KEY (account_id) REFERENCES ACCOUNT (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



CREATE TABLE ORDER_ITEMS
(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  QTY_ORDERED bigint(20) NOT NULL,
  unit_price double NOT NULL,
  order_id bigint(20) NOT NULL,
  product_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY (order_id),
  KEY (product_id),
  CONSTRAINT FOREIGN KEY (product_id) REFERENCES product(id),
  CONSTRAINT FOREIGN KEY (order_id) REFERENCES ORDER (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
