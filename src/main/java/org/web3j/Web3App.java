package org.web3j;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.generated.contracts.Escrow;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
 

public class Web3App {

	  private static final Logger log = LoggerFactory.getLogger(Web3App.class);

	    private void script() throws Exception {
 
	        Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:7545"));
	        log.info("Connected to client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());
	        
	        Credentials credentials =
	                WalletUtils.loadCredentials(
	                        "admin123",
	                        "cred.json"); 
 
	       /* TransactionReceipt transferReceipt = Transfer.sendFunds(
	                web3j, credentials,
	                "0x8da9230311977DED8171ba74Fe76325969c6DaDe",   
	                BigDecimal.ONE, Convert.Unit.WEI)   
	                .send();
	        log.info("Send done.."+ transferReceipt.getTransactionHash());
*/ 
	        log.info("Deploying smart contract");
	        //ContractGasProvider contractGasProvider = new DefaultGasProvider();
	        ContractGasProvider contractGasProvider = new StaticGasProvider(BigInteger.valueOf(4_100_000_000L),BigInteger.valueOf(6721975)); 
	        Escrow contract = Escrow.deploy(
	                web3j,
	                credentials,
	                contractGasProvider
	                ).send();

	        List<String> accounts=web3j.ethAccounts().send().getAccounts();
	        String contractAddress = contract.getContractAddress();
	        String buyer1=accounts.get(1);
	        String buyer2=accounts.get(2);
	        String seller1=accounts.get(3);
	        String seller2=accounts.get(4);
	        log.info("Smart contract deployed to address " + contractAddress); 
	        
	        log.info("Total Escrow Balance as of Initial: " + contract.getEscrowBalanceTotal().send());
	        int action_counter=0;
	        log.info("Action "+(++action_counter) +" - Buyer 1 | ADD");
	        TransactionReceipt transactionReceipt =contract.addBuyer(buyer1).send();
	        //log.info("Transaction Successfull-"+transactionReceipt.getTransactionHash());
	        
	        log.info("Action "+(++action_counter) +" - Buyer 2 | ADD ");
	        transactionReceipt = contract.addBuyer(buyer2).send();
	        
	        log.info("Action "+(++action_counter) +" - Seller 1 | ADD");
	        transactionReceipt =contract.addBuyer(seller1).send();
	        
	        log.info("Action "+(++action_counter) +" - Seller 2 | ADD ");
	        transactionReceipt = contract.addBuyer(seller2).send();
	        
	        
	        log.info("Action "+(++action_counter) +" - Buyer 1 | Credit | 20");
	        transactionReceipt =contract.credit(buyer1,  convertToSmallUnits(20)).send();
	        
	        
	        log.info("Action "+(++action_counter) +" - Buyer 2 | Credit | 40");
	        transactionReceipt =contract.credit(buyer2,  convertToSmallUnits(40)).send();
	        
	        log.info("Action "+(++action_counter) +" - Seller 1 | Offer | Coffee, 3");
	        transactionReceipt =contract.offer(seller1,   stringToBytes32("Coffee"),convertToSmallUnits(3)).send();

	        log.info("Action "+(++action_counter) +" - Seller 2 | Offer | T-Shirt, 5");
	        transactionReceipt =contract.offer(seller2,   stringToBytes32("T-Shirt"),convertToSmallUnits(5)).send();

	        log.info("Action "+(++action_counter) +" - Seller 1 | Offer | Tea, 2.5");
	        transactionReceipt =contract.offer(seller1,  stringToBytes32("Tea"),convertToSmallUnits(2.5)).send();	        

	        log.info("Action "+(++action_counter) +" - Seller 1 | Offer | Cake, 3.5");
	        transactionReceipt =contract.offer(seller1,  stringToBytes32("Cake"),convertToSmallUnits(3.5)).send();

	        log.info("Action "+(++action_counter) +" - Seller 2 | Offer | Shorts, 8");
	        transactionReceipt =contract.offer(seller2,  stringToBytes32("Shorts"),convertToSmallUnits(8)).send();	        

	        log.info("Action "+(++action_counter) +" - Seller 2 | Offer | Hoody, 12");
	        transactionReceipt =contract.offer(seller2,  stringToBytes32("Hoody"),convertToSmallUnits(12)).send();
	        
	        log.info("Action "+(++action_counter) +" - Buyer 1 | Order | T-Shirt");
	        transactionReceipt =contract.order(buyer1,  stringToBytes32("T-Shirt")).send();
	        
	        log.info("Action "+(++action_counter) +" - Buyer 1 | Deposit | 10");
	        transactionReceipt =contract.deposit(buyer1,  convertToSmallUnits(10)).send();
	        
	        log.info("Action "+(++action_counter) +" - Buyer 2 | Deposit | 10");
	        transactionReceipt =contract.deposit(buyer2,  convertToSmallUnits(12)).send();
 
	        log.info("Action "+(++action_counter) +" - Buyer 2 | Order | Hoody");
	        transactionReceipt =contract.order(buyer2, stringToBytes32("Hoody")).send();
	        
	        log.info("Action "+(++action_counter) +" - Buyer 1 | Complete | T-Shirt");
	        transactionReceipt =contract.complete(buyer1, stringToBytes32("T-Shirt")).send();

	        log.info("Action "+(++action_counter) +" - Buyer 1 | Order | Coffee");
	        transactionReceipt =contract.order(buyer1, stringToBytes32("Coffee")).send();

	        log.info("Action "+(++action_counter) +" - Buyer 1 | Order | Cake");
	        transactionReceipt =contract.order(buyer1, stringToBytes32("Cake")).send();

	        log.info("Action "+(++action_counter) +" - Buyer 2 | Complain | Hoody");
	        transactionReceipt =contract.complain(buyer2, stringToBytes32("Hoody")).send();

	        log.info("Action "+(++action_counter) +" - Buyer 2 | Order | Tea");
	        transactionReceipt =contract.order(buyer2, stringToBytes32("Tea")).send();	        

	        log.info("Action "+(++action_counter) +" - Buyer 1 | Complete | Coffee");
	        transactionReceipt =contract.complete(buyer1, stringToBytes32("Coffee")).send();
	       
 
	        log.info("############################################################################# "); 
	        log.info("Total Escrow Balance as of Latest: " + contract.getEscrowBalanceTotal().send()); 
	        	   
	    }
	    
	    public static Bytes32 stringToBytes32(String string) {
	        byte[] byteValue = string.getBytes();
	        byte[] byteValueLen32 = new byte[32];
	        System.arraycopy(byteValue, 0, byteValueLen32, 0, byteValue.length);
	        return new Bytes32(byteValueLen32);
	    }
	    
	    public static BigInteger convertToSmallUnits(double amount) {
	         return BigDecimal.valueOf(amount*100).toBigInteger();	        		
	    }
	    

	    public static void main(String[] args) throws Exception {
	    	 LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory(); 
	    	  StatusPrinter.print(lc);
	        new Web3App().script();
	    }


}
