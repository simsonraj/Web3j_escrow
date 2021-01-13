package org.web3j.generated.contracts;

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
    public static final String BINARY = "608060405234801561001057600080fd5b5060078054600160a060020a0319163317905561117e806100326000396000f3fe608060405234801561001057600080fd5b50600436106100d1576000357c0100000000000000000000000000000000000000000000000000000000900480639b3cdf5a1161008e5780639b3cdf5a146101a4578063b0f8e378146101d0578063bbf89803146101fc578063d93fabfa14610222578063f0d0d14914610248578063f8b2cb4f1461027a576100d1565b80631a8dea36146100d65780633546bf2814610104578063402fd63f1461011e5780635b3d18391461014a5780635faab07e146101765780639672ba571461017e575b600080fd5b610102600480360360408110156100ec57600080fd5b50600160a060020a0381351690602001356102a0565b005b61010c6103bb565b60408051918252519081900360200190f35b6101026004803603604081101561013457600080fd5b50600160a060020a0381351690602001356103c1565b6101026004803603604081101561016057600080fd5b50600160a060020a038135169060200135610452565b61010c610693565b61010c6004803603602081101561019457600080fd5b5035600160a060020a0316610699565b610102600480360360408110156101ba57600080fd5b50600160a060020a0381351690602001356106ab565b610102600480360360408110156101e657600080fd5b50600160a060020a03813516906020013561096d565b6101026004803603602081101561021257600080fd5b5035600160a060020a0316610c1d565b6101026004803603602081101561023857600080fd5b5035600160a060020a0316610ca3565b6101026004803603606081101561025e57600080fd5b50600160a060020a038135169060208101359060400135610d29565b61010c6004803603602081101561029057600080fd5b5035600160a060020a0316610e1c565b600754600160a060020a03163314806102cd57503360009081526005602052604090205460ff1615156001145b61030f576040805160e560020a62461bcd02815260206004820152601f6024820152600080516020611107833981519152604482015290519081900360640190fd5b600160a060020a03821660009081526002602052604081205413801561033d57508061033a83610e1c565b12155b1561037d57600160a060020a03821660009081526002602052604090208054829003905561036d82826001610e37565b610378826001610f27565b6103b7565b60405160e560020a62461bcd0281526004018080602001828103825260228152602001806111276022913960400191505060405180910390fd5b5050565b60005481565b600754600160a060020a03163314806103ee57503360009081526005602052604090205460ff1615156001145b610430576040805160e560020a62461bcd02815260206004820152601f6024820152600080516020611107833981519152604482015290519081900360640190fd5b600160a060020a03909116600090815260026020526040902080549091019055565b600754600160a060020a031633148061047f57503360009081526005602052604090205460ff1615156001145b6104c1576040805160e560020a62461bcd02815260206004820152601f6024820152600080516020611107833981519152604482015290519081900360640190fd5b600081815260016020908152604080832060020154600160a060020a0386168452600390925290912054126105c257600160a060020a0382811660009081526004602081815260408084208151878652600180855283872060a0830185528054838601908152818301548a1660608501526002918201546080850152835282860182815284548084018655948952978690208351805195890290910194855595860151848301805473ffffffffffffffffffffffffffffffffffffffff191691909a161790985593909201519581019590955592516003850180549495949193909260ff19909216919084908111156105b657fe5b021790555050506103b7565b600160a060020a0382811660009081526004602081815260408084208151878652600180855283872060a0830185528054838601908152818301548a1660608501526002918201546080850152835282860188815284548084018655948952978690208351805195890290910194855595860151848301805473ffffffffffffffffffffffffffffffffffffffff191691909a161790985593909201519581019590955592516003850180549495949193909260ff199092169190849081111561068857fe5b021790555050505050565b60005490565b60036020526000908152604090205481565b600754600160a060020a03163314806106d857503360009081526005602052604090205460ff1615156001145b61071a576040805160e560020a62461bcd02815260206004820152601f6024820152600080516020611107833981519152604482015290519081900360640190fd5b600160a060020a0382166000908152600460209081526040808320805482518185028101850190935280835260609492939192909184015b828210156107d95760008481526020908190206040805160a081018252600480870290930180549282019283526001810154600160a060020a03166060830152600281015460808301529181526003820154909391929184019160ff909116908111156107bb57fe5b60048111156107c657fe5b8152505081526020019060010190610752565b50505050905060005b815181101561096757828282815181106107f857fe5b60200260200101516000015160000151141561095f57600082828151811061081c57fe5b602002602001015160200151600481111561083357fe5b14156108735760405160e560020a62461bcd0281526004018080602001828103825260478152602001806110956047913960600191505060405180910390fd5b600382828151811061088157fe5b602002602001015160200151600481111561089857fe5b14156108ee576040805160e560020a62461bcd02815260206004820152601760248201527f4f7264657220436f6d706c6574656420416c7265616479000000000000000000604482015290519081900360640190fd5b60048282815181106108fc57fe5b602002602001015160200190600481111561091357fe5b9081600481111561092057fe5b905250600160a060020a038416600090815260036020818152604080842080546002845291852080549092019091559190525461095f91869190610e37565b6001016107e2565b50505050565b600754600160a060020a031633148061099a57503360009081526005602052604090205460ff1615156001145b6109dc576040805160e560020a62461bcd02815260206004820152601f6024820152600080516020611107833981519152604482015290519081900360640190fd5b600160a060020a0382166000908152600460209081526040808320805482518185028101850190935280835260609492939192909184015b82821015610a9b5760008481526020908190206040805160a081018252600480870290930180549282019283526001810154600160a060020a03166060830152600281015460808301529181526003820154909391929184019160ff90911690811115610a7d57fe5b6004811115610a8857fe5b8152505081526020019060010190610a14565b50505050905060005b81518110156109675782828281518110610aba57fe5b602002602001015160000151600001511415610c15576003828281518110610ade57fe5b6020026020010151602001516004811115610af557fe5b14610bc5576003828281518110610b0857fe5b6020026020010151602001906004811115610b1f57fe5b90816004811115610b2c57fe5b81525050818181518110610b3c57fe5b6020026020010151600001516040015160026000848481518110610b5c57fe5b60200260200101516000015160200151600160a060020a0316600160a060020a0316815260200190815260200160002060008282540192505081905550610bc084838381518110610ba957fe5b602002602001015160000151604001516000610e37565b610c15565b6040805160e560020a62461bcd02815260206004820152601760248201527f4f7264657220436f6d706c6574656420416c7265616479000000000000000000604482015290519081900360640190fd5b600101610aa4565b600754600160a060020a03163314610c7f576040805160e560020a62461bcd02815260206004820152601f60248201527f4f6e6c792041646d696e2063616e2063616c6c2074686973206d6574686f6400604482015290519081900360640190fd5b600160a060020a03166000908152600560205260409020805460ff19166001179055565b600754600160a060020a03163314610d05576040805160e560020a62461bcd02815260206004820152601f60248201527f4f6e6c792041646d696e2063616e2063616c6c2074686973206d6574686f6400604482015290519081900360640190fd5b600160a060020a03166000908152600660205260409020805460ff19166001179055565b600754600160a060020a0316331480610d5657503360009081526006602052604090205460ff1615156001145b610daa576040805160e560020a62461bcd02815260206004820181905260248201527f4f6e6c792073656c6c65722063616e2063616c6c2074686973206d6574686f64604482015290519081900360640190fd5b610db2611074565b5060408051606081018252838152600160a060020a039485166020808301918252828401948552600095865260019081905292909420905181559251908301805473ffffffffffffffffffffffffffffffffffffffff191691909416179092559051600290910155565b600160a060020a031660009081526002602052604090205490565b6000816001811115610e4557fe5b1415610ee9576000826000540312158015610e7a5750600160a060020a03831660009081526003602052604081205483900312155b15610eaa57600160a060020a03831660009081526003602052604081208054849003905580548390039055610ee4565b60405160e560020a62461bcd02815260040180806020018281038252602b8152602001806110dc602b913960400191505060405180910390fd5b610f22565b6001816001811115610ef757fe5b1415610f2257600160a060020a03831660009081526003602052604081208054840190558054830190555b505050565b600160a060020a0382166000908152600460209081526040808320805482518185028101850190935280835260609492939192909184015b82821015610fe65760008481526020908190206040805160a081018252600480870290930180549282019283526001810154600160a060020a03166060830152600281015460808301529181526003820154909391929184019160ff90911690811115610fc857fe5b6004811115610fd357fe5b8152505081526020019060010190610f5f565b50505050905060005b815181101561096757600183600481111561100657fe5b141561106c5761101584610e1c565b82828151811061102157fe5b602002602001015160000151604001511361106c57600182828151811061104457fe5b602002602001015160200190600481111561105b57fe5b9081600481111561106857fe5b9052505b600101610fef565b60408051606081018252600080825260208201819052918101919091529056fe5061796d656e74206e6f742079657420646f6e6520666f7220746865206974656d206f7220496e73756666696369656e7420616d6f756e7420746f20706c616365204f72646572496e73756666696369656e7420416d6f756e7420696e2074686520657363726f7720746f206465647563744f6e6c792062757965722063616e2063616c6c2074686973206d6574686f6400496e73756666696369656e742042616c616e636520666f7220746865204275796572a264697066735822122059b90874177e588734b66cf9633acdbe7ad2a15ae1832d6489d90be61cbfd2fa64736f6c63430007010033";

    public static final String FUNC_ADDBUYER = "addBuyer";

    public static final String FUNC_ADDSELLER = "addSeller";

    public static final String FUNC_COMPLAIN = "complain";

    public static final String FUNC_COMPLETE = "complete";

    public static final String FUNC_CREDIT = "credit";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_ESCROWBALANCES = "escrowBalances";

    public static final String FUNC_ESCROWTOTAL = "escrowTotal";

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

    public RemoteFunctionCall<TransactionReceipt> complain(String buyer,  org.web3j.abi.datatypes.generated.Bytes32 item) {
        final Function function = new Function(
                FUNC_COMPLAIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, buyer), 
                item), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> complete(String buyer,  org.web3j.abi.datatypes.generated.Bytes32 item) {
        final Function function = new Function(
                FUNC_COMPLETE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, buyer), 
                item), 
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

    public RemoteFunctionCall<BigInteger> escrowTotal() {
        final Function function = new Function(FUNC_ESCROWTOTAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getBalance(String buyer) {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, buyer)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getEscrowBalanceTotal() {
        final Function function = new Function(FUNC_GETESCROWBALANCETOTAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> offer(String seller,  org.web3j.abi.datatypes.generated.Bytes32 item, BigInteger amount) {
        final Function function = new Function(
                FUNC_OFFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, seller), 
                item, 
                new org.web3j.abi.datatypes.generated.Int256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> order(String buyer,  org.web3j.abi.datatypes.generated.Bytes32 item) {
        final Function function = new Function(
                FUNC_ORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, buyer), 
                item), 
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
