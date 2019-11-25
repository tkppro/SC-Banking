package vnuk.cse.scbanking;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import vnuk.cse.scbanking.controller.DashboardController;
import vnuk.cse.scbanking.controller.WalletController;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.service.WalletService;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class TestWalletService {

    @Mock
    private WalletService walletService;

    @InjectMocks
    private WalletController walletController;

    @InjectMocks
    private DashboardController dashboardController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(walletController).build();

    }

    @Test
    public void getWalletList() throws Exception {

        List<Wallet> walletList = new ArrayList<Wallet>();
        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();

        walletList.add(wallet1);
        walletList.add(wallet2);

        when(walletService.findAll()).thenReturn(walletList);

        // Test
        mockMvc.perform(get("/wallets"))
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/wallets"))
                .andExpect(model().attribute("wallets", hasSize(2)));
    }

    @Test
    public void saveWallet() throws Exception {
        Wallet wallet = new Wallet();
        when(walletService.saveWallet(wallet)).thenReturn(wallet);

        assertEquals(wallet, walletService.saveWallet(wallet));
    }

}
