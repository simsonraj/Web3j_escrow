package org.web3j.escrow;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.2.
 */
@SuppressWarnings("rawtypes")
public class Escrow extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5060078054600160a060020a03191633179055611165806100326000396000f3fe608060405234801561001057600080fd5b50600436106100c6576000357c0100000000000000000000000000000000000000000000000000000000900480639b3cdf5a1161008e5780639b3cdf5a14610191578063b0f8e378146101bd578063bbf89803146101e9578063d93fabfa1461020f578063f0d0d14914610235578063f8b2cb4f14610267576100c6565b80631a8dea36146100cb578063402fd63f146100f95780635b3d1839146101255780635faab07e146101515780639672ba571461016b575b600080fd5b6100f7600480360360408110156100e157600080fd5b50600160a060020a03813516906020013561028d565b005b6100f76004803603604081101561010f57600080fd5b50600160a060020a0381351690602001356103a8565b6100f76004803603604081101561013b57600080fd5b50600160a060020a038135169060200135610439565b61015961067a565b60408051918252519081900360200190f35b6101596004803603602081101561018157600080fd5b5035600160a060020a0316610680565b6100f7600480360360408110156101a757600080fd5b50600160a060020a038135169060200135610692565b6100f7600480360360408110156101d357600080fd5b50600160a060020a038135169060200135610954565b6100f7600480360360208110156101ff57600080fd5b5035600160a060020a0316610c04565b6100f76004803603602081101561022557600080fd5b5035600160a060020a0316610c8a565b6100f76004803603606081101561024b57600080fd5b50600160a060020a038135169060208101359060400135610d10565b6101596004803603602081101561027d57600080fd5b5035600160a060020a0316610e03565b600754600160a060020a03163314806102ba57503360009081526005602052604090205460ff1615156001145b6102fc576040805160e560020a62461bcd02815260206004820152601f60248201526000805160206110ee833981519152604482015290519081900360640190fd5b600160a060020a03821660009081526002602052604081205413801561032a57508061032783610e03565b12155b1561036a57600160a060020a03821660009081526002602052604090208054829003905561035a82826001610e1e565b610365826001610f0e565b6103a4565b60405160e560020a62461bcd02815260040180806020018281038252602281526020018061110e6022913960400191505060405180910390fd5b5050565b600754600160a060020a03163314806103d557503360009081526005602052604090205460ff1615156001145b610417576040805160e560020a62461bcd02815260206004820152601f60248201526000805160206110ee833981519152604482015290519081900360640190fd5b600160a060020a03909116600090815260026020526040902080549091019055565b600754600160a060020a031633148061046657503360009081526005602052604090205460ff1615156001145b6104a8576040805160e560020a62461bcd02815260206004820152601f60248201526000805160206110ee833981519152604482015290519081900360640190fd5b600081815260016020908152604080832060020154600160a060020a0386168452600390925290912054126105a957600160a060020a0382811660009081526004602081815260408084208151878652600180855283872060a0830185528054838601908152818301548a1660608501526002918201546080850152835282860182815284548084018655948952978690208351805195890290910194855595860151848301805473ffffffffffffffffffffffffffffffffffffffff191691909a161790985593909201519581019590955592516003850180549495949193909260ff199092169190849081111561059d57fe5b021790555050506103a4565b600160a060020a0382811660009081526004602081815260408084208151878652600180855283872060a0830185528054838601908152818301548a1660608501526002918201546080850152835282860188815284548084018655948952978690208351805195890290910194855595860151848301805473ffffffffffffffffffffffffffffffffffffffff191691909a161790985593909201519581019590955592516003850180549495949193909260ff199092169190849081111561066f57fe5b021790555050505050565b60005490565b60036020526000908152604090205481565b600754600160a060020a03163314806106bf57503360009081526005602052604090205460ff1615156001145b610701576040805160e560020a62461bcd02815260206004820152601f60248201526000805160206110ee833981519152604482015290519081900360640190fd5b600160a060020a0382166000908152600460209081526040808320805482518185028101850190935280835260609492939192909184015b828210156107c05760008481526020908190206040805160a081018252600480870290930180549282019283526001810154600160a060020a03166060830152600281015460808301529181526003820154909391929184019160ff909116908111156107a257fe5b60048111156107ad57fe5b8152505081526020019060010190610739565b50505050905060005b815181101561094e57828282815181106107df57fe5b60200260200101516000015160000151141561094657600082828151811061080357fe5b602002602001015160200151600481111561081a57fe5b141561085a5760405160e560020a62461bcd02815260040180806020018281038252604781526020018061107c6047913960600191505060405180910390fd5b600382828151811061086857fe5b602002602001015160200151600481111561087f57fe5b14156108d5576040805160e560020a62461bcd02815260206004820152601760248201527f4f7264657220436f6d706c6574656420416c7265616479000000000000000000604482015290519081900360640190fd5b60048282815181106108e357fe5b60200260200101516020019060048111156108fa57fe5b9081600481111561090757fe5b905250600160a060020a038416600090815260036020818152604080842080546002845291852080549092019091559190525461094691869190610e1e565b6001016107c9565b50505050565b600754600160a060020a031633148061098157503360009081526005602052604090205460ff1615156001145b6109c3576040805160e560020a62461bcd02815260206004820152601f60248201526000805160206110ee833981519152604482015290519081900360640190fd5b600160a060020a0382166000908152600460209081526040808320805482518185028101850190935280835260609492939192909184015b82821015610a825760008481526020908190206040805160a081018252600480870290930180549282019283526001810154600160a060020a03166060830152600281015460808301529181526003820154909391929184019160ff90911690811115610a6457fe5b6004811115610a6f57fe5b81525050815260200190600101906109fb565b50505050905060005b815181101561094e5782828281518110610aa157fe5b602002602001015160000151600001511415610bfc576003828281518110610ac557fe5b6020026020010151602001516004811115610adc57fe5b14610bac576003828281518110610aef57fe5b6020026020010151602001906004811115610b0657fe5b90816004811115610b1357fe5b81525050818181518110610b2357fe5b6020026020010151600001516040015160026000848481518110610b4357fe5b60200260200101516000015160200151600160a060020a0316600160a060020a0316815260200190815260200160002060008282540192505081905550610ba784838381518110610b9057fe5b602002602001015160000151604001516000610e1e565b610bfc565b6040805160e560020a62461bcd02815260206004820152601760248201527f4f7264657220436f6d706c6574656420416c7265616479000000000000000000604482015290519081900360640190fd5b600101610a8b565b600754600160a060020a03163314610c66576040805160e560020a62461bcd02815260206004820152601f60248201527f4f6e6c792041646d696e2063616e2063616c6c2074686973206d6574686f6400604482015290519081900360640190fd5b600160a060020a03166000908152600560205260409020805460ff19166001179055565b600754600160a060020a03163314610cec576040805160e560020a62461bcd02815260206004820152601f60248201527f4f6e6c792041646d696e2063616e2063616c6c2074686973206d6574686f6400604482015290519081900360640190fd5b600160a060020a03166000908152600660205260409020805460ff19166001179055565b600754600160a060020a0316331480610d3d57503360009081526006602052604090205460ff1615156001145b610d91576040805160e560020a62461bcd02815260206004820181905260248201527f4f6e6c792073656c6c65722063616e2063616c6c2074686973206d6574686f64604482015290519081900360640190fd5b610d9961105b565b5060408051606081018252838152600160a060020a039485166020808301918252828401948552600095865260019081905292909420905181559251908301805473ffffffffffffffffffffffffffffffffffffffff191691909416179092559051600290910155565b600160a060020a031660009081526002602052604090205490565b6000816001811115610e2c57fe5b1415610ed0576000826000540312158015610e615750600160a060020a03831660009081526003602052604081205483900312155b15610e9157600160a060020a03831660009081526003602052604081208054849003905580548390039055610ecb565b60405160e560020a62461bcd02815260040180806020018281038252602b8152602001806110c3602b913960400191505060405180910390fd5b610f09565b6001816001811115610ede57fe5b1415610f0957600160a060020a03831660009081526003602052604081208054840190558054830190555b505050565b600160a060020a0382166000908152600460209081526040808320805482518185028101850190935280835260609492939192909184015b82821015610fcd5760008481526020908190206040805160a081018252600480870290930180549282019283526001810154600160a060020a03166060830152600281015460808301529181526003820154909391929184019160ff90911690811115610faf57fe5b6004811115610fba57fe5b8152505081526020019060010190610f46565b50505050905060005b815181101561094e576001836004811115610fed57fe5b141561105357610ffc84610e03565b82828151811061100857fe5b602002602001015160000151604001511361105357600182828151811061102b57fe5b602002602001015160200190600481111561104257fe5b9081600481111561104f57fe5b9052505b600101610fd6565b60408051606081018252600080825260208201819052918101919091529056fe5061796d656e74206e6f742079657420646f6e6520666f7220746865206974656d206f7220496e73756666696369656e7420616d6f756e7420746f20706c616365204f72646572496e73756666696369656e7420416d6f756e7420696e2074686520657363726f7720746f206465647563744f6e6c792062757965722063616e2063616c6c2074686973206d6574686f6400496e73756666696369656e742042616c616e636520666f7220746865204275796572a26469706673582212205a8b6fc3c05fd439e454559450f6a1ec0342095a867f0f11f2b3a3e19ef47b0d64736f6c63430007010033";

    public static final String FUNC_ADDBUYER = "addBuyer";

    public static final String FUNC_ADDSELLER = "addSeller";

    public static final String FUNC_COMPLAIN = "complain";

    public static final String FUNC_COMPLETE = "complete";

    public static final String FUNC_CREDIT = "credit";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_ESCROWBALANCES = "escrowBalances";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_GETESCROWBALANCETOTAL = "getEscrowBalanceTotal";

    public static final String FUNC_OFFER = "offer";

    public static final String FUNC_ORDER = "order";

    @Deprecated
    protected Escrow(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Escrow(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Escrow(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Escrow(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addBuyer(String buyer) {
        final Function function = new Function(
                FUNC_ADDBUYER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, buyer)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addSeller(String seller) {
        final Function function = new Function(
                FUNC_ADDSELLER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, seller)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> complain(String buyer, byte[] item) {
        final Function function = new Function(
                FUNC_COMPLAIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, buyer), 
                new org.web3j.abi.datatypes.generated.Bytes32(item)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> complete(String buyer, byte[] item) {
        final Function function = new Function(
                FUNC_COMPLETE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, buyer), 
                new org.web3j.abi.datatypes.generated.Bytes32(item)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> credit(String buyer, BigInteger amount) {
        final Function function = new Function(
                FUNC_CREDIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, buyer), 
                new org.web3j.abi.datatypes.generated.Int256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> deposit(String buyer, BigInteger amount) {
        final Function function = new Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, buyer), 
                new org.web3j.abi.datatypes.generated.Int256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> escrowBalances(String param0) {
        final Function function = new Function(FUNC_ESCROWBALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getBalance(String buyer) {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, buyer)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> getEscrowBalanceTotal() {
        final Function function = new Function(
                FUNC_GETESCROWBALANCETOTAL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> offer(String seller, byte[] item, BigInteger amount) {
        final Function function = new Function(
                FUNC_OFFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, seller), 
                new org.web3j.abi.datatypes.generated.Bytes32(item), 
                new org.web3j.abi.datatypes.generated.Int256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> order(String buyer, byte[] item) {
        final Function function = new Function(
                FUNC_ORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, buyer), 
                new org.web3j.abi.datatypes.generated.Bytes32(item)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Escrow load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Escrow(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Escrow load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Escrow(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Escrow load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Escrow(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Escrow load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Escrow(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Escrow> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Escrow.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Escrow> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Escrow.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Escrow> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Escrow.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Escrow> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Escrow.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
