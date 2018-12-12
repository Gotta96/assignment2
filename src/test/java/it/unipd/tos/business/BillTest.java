package it.unipd.tos.business;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BillTest {

	 //Tot somma (issue #1)
	
    @org.junit.Test
    public void TotalSimpleBillSomeItemsTest() {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem("Bigoli al torcio in salsa",MenuItem.alimenti.PRIMO_PIATTO, 10.5));
        itemsOrdered.add(new MenuItem("Lasagne alla bolognese rivisitate", MenuItem.alimenti.PRIMO_PIATTO, 12.0));
        Bill bill = new Bill();
        try {
            double tot = bill.getOrderPrice(itemsOrdered);
            assertEquals(22.5, tot, 0.0);
        } catch (RestaurantBillException e) {
            e.getAvviso();
        }
    }

}