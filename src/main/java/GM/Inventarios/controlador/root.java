package GM.Inventarios.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class root {

    @GetMapping
    public String root(){
        return "Pagina de inicio para la API";
    }


}
