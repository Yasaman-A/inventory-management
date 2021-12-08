import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockTest {
	Stock stock;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}


	@BeforeEach
	void setUp() throws Exception {
		 SupDirectory dir = new SupDirectory();  
	     stock = new Stock(dir);
	}


	@Test
	void testSearchInventoryExistingItem() {
		//exercise
		String name="Widgets";
		int id = 1001;
		Tool tool = stock.searchInventory(name, id);
		int actualId = tool.getId();
		
		//assertion
		int expectedId = 1001;
		assertEquals(expectedId, actualId);
	}
	
	
	@Test
	void testSearchInventoryNonExistingItem() {
		//exercise
		String name="Widgets";
		int id = 5001;
		Tool actualTool = stock.searchInventory(name, id);
		int actualId = actualTool.getId();
		
		//assertion
		Tool expectedTool = new Tool();
		int expectedId = expectedTool.getId();
		
		System.out.println("expectedId:" + expectedId);
		System.out.println("actualId:" + actualId);
		assertEquals(expectedId, actualId);
	}
	

	@Test
	void testDeleteExistingItem() {
		String name="Widgets";
		int id = 1001;
		
		
		Tool tool1 = stock.searchInventory(name, id);
		assertEquals(id, tool1.getId());
		
		stock.removeTool(name, id);
		
		Tool tool2 = stock.searchInventory(name, id);
		int expectedId = 0;
		assertEquals(expectedId, tool2.getId());
		
	}
	

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tear down ");
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tear down after class");
	}
}
