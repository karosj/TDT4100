package delegation.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee {

	private Printer printer = null;
	private int tasks;

	public Clerk(Printer printer) {
		this.printer = printer;
		this.tasks = 0;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		tasks++;
		return operation.apply(value1, value2);
	}

	@Override
	public void printDocument(String document) {
		if (printer != null) {
			tasks++;
			this.printer.printDocument(document, this);
		}
	}

	@Override
	public int getTaskCount() {
		return tasks;
	}

	@Override
	public int getResourceCount() {
		return 1;
	}
}
