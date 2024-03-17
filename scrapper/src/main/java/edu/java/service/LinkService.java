package edu.java.service;

import edu.java.control.commandDto.ListLinkResp;
import edu.java.dao.dto.LinkDto;
import java.net.URI;
import java.util.List;

public interface LinkService {
    Long add(long tgChatId, URI url);

    void remove(long tgChatId, URI url);

    ListLinkResp listAllByChatId(long tgChatId);

    List<LinkDto> listAll();
}
