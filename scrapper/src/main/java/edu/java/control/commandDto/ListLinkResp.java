package edu.java.control.commandDto;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Getter
public class ListLinkResp {
    private final List<LinkResp> links = new ArrayList<>();
    public void setLinks(List<String> urls, Long id) {
        for (String s : urls) {
            LinkResp linkResponse = new LinkResp(id, URI.create(s));
            links.add(linkResponse);
        }
    }
    public int getSize() {
        return links.size();
    }
}
