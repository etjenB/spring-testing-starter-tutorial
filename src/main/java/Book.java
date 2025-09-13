import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Book {
    private Long id;
    private String title;
    private String author;
    private Integer publishedYear;
    private Boolean inStock;
    private List<Integer> ratings;
}
