package mapping;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeResponseMap {
    private String partitionKey;
    private String sortKey;
    private String username;
    private String id;
    private String firstName;
    private String lastName;
    private int dependants;
    private String expiration;
    private float salary;
    private float gross;
    private float benefitsCost;
    private float net;
}