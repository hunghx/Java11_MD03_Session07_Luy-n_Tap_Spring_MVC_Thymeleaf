package ra.edu.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
public class FormRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
