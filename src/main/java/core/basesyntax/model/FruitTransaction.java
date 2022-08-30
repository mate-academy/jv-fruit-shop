package core.basesyntax.model;

public class FruitTransaction {
	private String operation;
	private Fruit fruit;
	private int quantity;

	public FruitTransaction(String operation, Fruit fruit, int quantity) {
		this.operation = operation;
		this.fruit = fruit;
		this.quantity = quantity;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "FruitTransaction{" +
				"operation=" + operation +
				", fruit='" + fruit + '\'' +
				", quantity=" + quantity +
				'}';
	}

	public enum Operation {
		BALANCE("b"),
		SUPPLY("s"),
		PURCHASE("p"),
		RETURN("r");

		private String operation;

		Operation(String operation) {
			this.operation = operation;
		}

		public String getOperation() {
			return operation;
		}
	}
}