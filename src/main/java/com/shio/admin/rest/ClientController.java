package com.shio.admin.rest;
import com.shio.admin.domain.Client;
import com.shio.admin.persistence.ClientRepository;
import com.shio.admin.DTO.ClientDTO;
import java.util.List;
import com.shio.admin.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;
    private final ClientService clientService;


    @GetMapping
    public List<ClientDTO> getAll(){
        return clientService.getAll();
    }

    /*
    @GetMapping()
    public List<ClientDTO> getAll(@RequestParam(value = "search_txt", required = false) String searchTxt) {
        return clientService.getClients(searchTxt);
    }*/

    @GetMapping("/{client_id}")
    public ClientDTO getSingle(@PathVariable("client_id") long clientId) {
        return clientService.getClient(clientId);
    }

    @PostMapping()
    public Client create(@Validated(Client.New.class) @RequestBody Client client) {
        return clientService.createClient(client);
    }

    /*@PutMapping()
    public ResponseEntity update(@Validated(Client.Existing.class) @RequestBody Client client) { // throws NotFoundException {
        if (clientRepository.findById(client.getId()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(clientRepository.save(client));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found client with id " + client.getId());
    }*/

    @PutMapping()
    public Client update(@Validated(Client.Existing.class) @RequestBody Client client) {
        return clientService.updateClient(client);
    }

}
