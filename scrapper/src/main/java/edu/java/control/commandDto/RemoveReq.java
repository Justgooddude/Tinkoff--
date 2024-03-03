package edu.java.control.commandDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.net.URI;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class RemoveReq {
    public URI kink;
}
