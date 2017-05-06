package pl.zdunek.myapp.web.rest.controllers;

import pl.zdunek.myapp.config.Constants;
import com.codahale.metrics.annotation.Timed;
import pl.zdunek.myapp.domain.User;
import pl.zdunek.myapp.repository.UserRepository;
import pl.zdunek.myapp.security.AuthoritiesConstants;
import pl.zdunek.myapp.service.MailService;
import pl.zdunek.myapp.service.UserService;
import pl.zdunek.myapp.service.dto.UserDTO;
import pl.zdunek.myapp.web.rest.vm.ManagedUserVM;
import pl.zdunek.myapp.web.rest.util.HeaderUtil;
import pl.zdunek.myapp.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * REST controller for managing users.
 *
 */

@RestController
@RequestMapping("/api")
public class ShowResource {


   
}
