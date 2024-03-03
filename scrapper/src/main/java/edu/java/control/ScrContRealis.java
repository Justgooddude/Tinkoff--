package edu.java.control;

import java.net.URI;
import java.util.List;
import edu.java.control.commandDto.AddRequest;
import edu.java.control.commandDto.LinkResp;
import edu.java.control.commandDto.ListLinkResp;
import edu.java.control.commandDto.RemoveReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ScrContRealis implements ScrapperControl {
    @Override
    public void addChat(long id) {
        //stub
    }

    @Override
    public void deleteChat(long id) {
        //stub
    }

    @Override
    public ListLinkResp getLinks(long id) {
        //stub
        return new ListLinkResp(List.of(new LinkResp (2, URI.create("https://www.google.com"))), 1);
    }

    @Override
    public LinkResp addLink(long id, AddRequest link) {
        //stub
        return new LinkResp(2, URI.create("https://www.google.com"));
    }

    @Override
    public LinkResp deleteLink(long id, RemoveReq link) {
        //stub
        return new LinkResp(2, URI.create("https://www.google.com"));
    }
}
