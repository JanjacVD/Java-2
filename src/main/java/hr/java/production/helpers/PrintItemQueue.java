package hr.java.production.helpers;

import hr.java.production.enums.Priority;
import hr.java.production.model.Item;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class PrintItemQueue {
    private static List<PrintItem> items = new ArrayList<>();
    private static Random random = new Random();

    public static void addToQueue(Item item, Priority priority){
        items.add(new PrintItem(LocalDateTime.now().plusMonths(random.nextInt(3)), item,priority));
    }

    public static void doPrint(){
        List<PrintItem> sortedItems = items.stream()
                .sorted(Comparator.comparing(PrintItem::getCreationDateTime))
                .toList();


        Map<String, Map<Priority, List<PrintItem>>> groupedItems =
                sortedItems.stream()
                .filter(x-> x.getPriority() != null)
                .collect(Collectors.groupingBy(
                        item-> YearMonth.from(item.getCreationDateTime()).toString(),
                        Collectors.groupingBy(PrintItem::getPriority)
                ));

        groupedItems.forEach((yearMonth, map) -> {
            System.out.println(yearMonth +":");
            map.forEach((p,itemMap) -> {
                System.out.println(p+ " " + itemMap.size() + ":");
                itemMap.forEach(System.out::println);
            });
        });
    }
}
