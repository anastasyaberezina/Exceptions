import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Exception3 {
    
    public static void main(String[] args) throws IOException {

        try {
            record();
            System.out.println("Запись выполнена");
        }catch (FileSystemException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }

    public static void record() throws Exception{
        System.out.println("Введите ФИО, дату рождения (в формате dd.mm.yyyy), номер телефона (без разделителей) и пол(символ f или m), разделенные пробелом");

        String text;
        try(BufferedReader x = new BufferedReader(new InputStreamReader(System.in))) {
            text = x.readLine();
        }catch (IOException e){
            throw new Exception("Ошибка!");
        }

        String[] array = text.split(" ");
        if (array.length != 6){
            throw new Exception("Неверные параметры");
        }

        String surname = array[0];
        String name = array[1];
        String patronymic = array[2];

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        Date date_of_birth;
        try {
            date_of_birth = (Date) format.parse(array[3]);
        }catch (ParseException e){
            throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
        }

        int phone_number;
        try {
            phone_number = Integer.parseInt(array[4]);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Неверно указан телефон");
        }

        String sex = array[5];
        if (!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f")){
            throw new RuntimeException("Неверно введен пол");
        }

        String fileName = "files\\" + surname.toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)){
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", surname, name, patronymic, format.format(date_of_birth), phone_number, sex));
        }catch (IOException e){
            throw new FileSystemException("Ошибка!");
        }

    }
}

