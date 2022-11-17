package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine();
		Consumer<Field> printer = field -> System.out.printf(
				"%s %s %s%n",
				Modifier.toString(field.getModifiers()),
				field.getType().getSimpleName(),
				field.getName());
		while(!"HARVEST".equals(command)){
			switch (command){
				case "public":
					Arrays.stream(fields)
							.filter(field -> Modifier.isPublic(field.getModifiers()))
							.forEach(printer);
					break;
				case "private":
					Arrays.stream(fields)
							.filter(field -> Modifier.isPrivate(field.getModifiers()))
							.forEach(printer);
					break;
				case "protected":
					Arrays.stream(fields)
							.filter(field -> Modifier.isProtected(field.getModifiers()))
							.forEach(printer);
					break;
				case "all":
					Arrays.stream(fields)
							.forEach(printer);
					break;
			}
			command = scanner.nextLine();
		}
	}
}
