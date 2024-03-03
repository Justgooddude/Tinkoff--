package edu.java.control.commandDto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ListLinkResp {
    public List<LinkResp> links;
    public int size;
}
