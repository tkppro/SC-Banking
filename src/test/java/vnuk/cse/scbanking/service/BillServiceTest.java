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
import vnuk.cse.scbanking.controller.BillController;
import vnuk.cse.scbanking.entity.Bill;
import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.Wallet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceTest {
    @Mock
    private BillService billService;
    @Mock
    private WalletService walletService;
    @Mock
    private CardService cardService;
    @InjectMocks
    private BillController billController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(billController).build();
    }

    @Test
    public void testGetBill() throws Exception {
        when(billService.findAll()).thenReturn(
                Stream.of(new Bill("Trash Service", new Date()),
                        new Bill("Trash Service 2", new Date())).collect(Collectors.toList()));
        assertEquals(2, billService.findAll().size());
    }

    @Test
    public void testSaveBill() throws Exception {
        Bill bill = new Bill("Test bill", new Date());
        when(billService.save(bill)).thenReturn(bill);
        assertEquals(bill, billService.save(bill));
    }

    @Test
    public void testDeleteBill() throws Exception {
        Bill bill = new Bill("Test bill", new Date());
        billService.delete(bill);
        verify(billService, times(1)).delete(bill);
    }

    @Test
    public void testList() throws Exception {
        List<Bill> bills = new ArrayList<>();
        bills.add(new Bill("Trash Service", new Date()));
        bills.add(new Bill("Trash Service2", new Date()));

        List<Wallet> wallets = new ArrayList<>();
        wallets.add(new Wallet());
        wallets.add(new Wallet());

        List<Card> cards = new ArrayList<>();
        cards.add(new Card());
        cards.add(new Card());


        when(billService.findAll()).thenReturn(bills);
        when(walletService.findAll()).thenReturn(wallets);
        when(cardService.findAll()).thenReturn(cards);

        mockMvc.perform(get("/payments"))
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/bill"))
                .andExpect(model().attribute("bills", hasSize(2)))
                .andExpect(model().attribute("wallets", hasSize(2)))
                .andExpect(model().attribute("cards", hasSize(2)));
    }
}