package delegation.office;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {

    private Map<Employee, ArrayList<String>> history = new HashMap<Employee, ArrayList<String>>();

    public void printDocument(String document, Employee employee) {
        ArrayList<String> newHistory = new ArrayList<String>();
        if (history.containsKey(employee)) {
            newHistory = history.get(employee);
        }
        newHistory.add(document);
        history.put(employee, newHistory);
    }

    public List<String> getPrintHistory(Employee employee) {
        if (history.get(employee) == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(history.get(employee));
    }
}
