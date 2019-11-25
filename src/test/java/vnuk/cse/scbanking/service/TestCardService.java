package vnuk.cse.scbanking.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import vnuk.cse.scbanking.controller.CardController;
import vnuk.cse.scbanking.controller.DashboardController;
import vnuk.cse.scbanking.entity.Bill;
import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.Transaction;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.service.CardService;
import vnuk.cse.scbanking.service.TransactionService;
import vnuk.cse.scbanking.service.WalletService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class TestCardService {
    @Mock
    CardService cardService;
    @Mock
    WalletService walletService;
    @Mock
    TransactionService transactionService;

    @InjectMocks
    DashboardController dashboardController;

    MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(dashboardController).build();
    }

    @Test
    public void testListCard() throws Exception {
        List<Card> cardList = new ArrayList<>();
        List<Wallet> walletList = new ArrayList<>();
        List<Transaction> transactionList = new ArrayList<>();
        cardList.add(new Card());
        walletList.add(new Wallet());
        transactionList.add(new Transaction());

        when(cardService.findAll()).thenReturn((List) cardList);
        when(walletService.findAll()).thenReturn((List) walletList);
        when(transactionService.findAll()).thenReturn((List) transactionList);

        mockMvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/dashboard"))
                .andExpect(model().attribute("cards", hasSize(1)))
                .andExpect(model().attribute("wallets", hasSize(1)))
                .andExpect(model().attribute("transactions", hasSize(1)));

    }
    @Test
    public void testSaveBill() throws Exception {
        Card card = new Card();
        when(cardService.saveCard(card)).thenReturn(card);
        assertEquals(card, cardService.saveCard(card));
    }

    @Test
    public void testDeleteBill() throws Exception {
        Card card = new Card();
        cardService.deleteCard(card);
        verify(cardService, times(1)).deleteCard(card);
    }
}
