package org.web3j.generated.contracts;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.EVMTest;
import org.web3j.Web3App;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

@EVMTest()
class EscrowTest {
  private static Escrow escrow;
  private static List<String> accounts;

  private static final Logger log = LoggerFactory.getLogger(Web3App.class);

  @BeforeAll
  static void deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) throws Exception {
    escrow = Escrow.deploy(web3j, transactionManager, contractGasProvider).send();
    web3j = Web3j.build(new HttpService("http://127.0.0.1:7545")); 
    accounts=web3j.ethAccounts().send().getAccounts();
  }

  @Test
  public void credit() throws Exception {
    TransactionReceipt transactionReceiptVar = escrow.credit(accounts.get(1), BigInteger.ONE).send();
    BigInteger bigIntegerVar = escrow.getBalance(accounts.get(1)).send(); 
    transactionReceiptVar = escrow.credit(accounts.get(2), BigInteger.ONE).send();
    bigIntegerVar = escrow.getBalance(accounts.get(1)).send();  
    Assertions.assertEquals(BigInteger.ONE, bigIntegerVar);
  }
 
  
  @Test
  public void offer() throws Exception {
    TransactionReceipt transactionReceiptVar = escrow.offer(accounts.get(3),stringToBytes32("Coffee"), BigInteger.ONE).send();
    Assertions.assertTrue(transactionReceiptVar.isStatusOK());
  }

  
  @Test
  public void order() throws Exception {
    TransactionReceipt transactionReceiptVar = escrow.order(accounts.get(1), stringToBytes32("Coffee")).send();
    Assertions.assertTrue(transactionReceiptVar.isStatusOK());
  }
  

  
  @Test
  public void deposit() throws Exception {	 
	TransactionReceipt transactionReceiptVar = escrow.deposit(accounts.get(1), BigInteger.ONE).send();
	Assertions.assertTrue(transactionReceiptVar.isStatusOK());
  }


 
  @Test
  public void complete() throws Exception {
    TransactionReceipt transactionReceiptVar = escrow.complete(accounts.get(1), stringToBytes32("Coffee")).send();
    BigInteger bigIntegerVar = escrow.escrowBalances(accounts.get(1)).send();    
    Assertions.assertEquals(BigInteger.valueOf(0), bigIntegerVar);
  }


  @Test
  public void complain() throws Exception {
    TransactionReceipt transactionReceiptVar = escrow.complain(accounts.get(1), stringToBytes32("Coffee")).send();
    Assertions.assertTrue(transactionReceiptVar.isStatusOK());
  }

  @Test
  public void getEscrowBalanceTotal() throws Exception {
    BigInteger bigIntegerVar = escrow.getEscrowBalanceTotal().send();
    Assertions.assertEquals(BigInteger.ONE, bigIntegerVar);
  }
  
  
  public static Bytes32 stringToBytes32(String string) {
      byte[] byteValue = string.getBytes();
      byte[] byteValueLen32 = new byte[32];
      System.arraycopy(byteValue, 0, byteValueLen32, 0, byteValue.length);
      return new Bytes32(byteValueLen32);
  }
}
