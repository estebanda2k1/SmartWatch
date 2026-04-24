package SmartWallet;
import org.SmartWallet.SmartWallet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmartWalletTest {
        private SmartWallet wallet;
        @BeforeEach
            void arranque(){
                wallet=new SmartWallet("Standard");
        }
        @Test
            void testDeposit(){
            assertTrue(wallet.deposit(50));
            assertEquals(50,wallet.getSaldo());
        }
        @Test
            void testDepositNegativo(){
            assertFalse(wallet.deposit(-50));
        }
        @Test
            void testDepositNoCashback(){
            assertTrue(wallet.deposit(50));
            assertEquals(50,wallet.getSaldo());
        }
        @Test
            void testDepositExactly100(){
            assertTrue(wallet.deposit(100));
            assertEquals(100,wallet.getSaldo());
        }
        @Test
            void testDepositCashback(){
            assertTrue(wallet.deposit(200));
            assertEquals(202,wallet.getSaldo());
        }
        @Test
            void testDepositoExcedido(){
            wallet.deposit(4999);
            assertFalse(wallet.deposit(200));
        }
        @Test
            void testWithdraw(){
            wallet.deposit(500);
            assertTrue(wallet.withdraw(200));
            assertEquals(305,wallet.getSaldo());
        }
        @Test
            void testWithdrawNegativo(){
            assertFalse(wallet.withdraw(-50));
        }
        @Test
            void testWithdrawSinSaldoSuficiente(){
            wallet.deposit(100);
            assertFalse(wallet.withdraw(200));
        }
        @Test
            void testWithdrawEstadoCliente(){
            wallet.deposit(200);
            wallet.withdraw(202);
            assertFalse(wallet.isEstadoUsuario());
        }
}