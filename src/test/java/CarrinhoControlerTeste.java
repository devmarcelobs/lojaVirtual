import com.example.lojavirtual.controller.CarrinhoController;
import com.example.lojavirtual.model.Carrinho;
import com.example.lojavirtual.repository.CarrinhoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CarrinhoControlerTeste {

    @Mock
    CarrinhoRepository carrinhoRepositoryMock;

    CarrinhoController carrinhoController;

    @BeforeAll
    public void Start() {
        carrinhoController = new CarrinhoController();
    }


    @Test
    public void RetrieveSuccess() {
        Mockito.when(carrinhoRepositoryMock.findAll()).thenReturn(new ArrayList<Carrinho>());

        List<Carrinho> actual = carrinhoController.retrieveCarrinho();




    }


    /*public List<Carrinho> getFakeList() {
        List<Carrinho> carrinhos = new ArrayList<>();
//        carrinhos.add(Ca)
    }*/


}
