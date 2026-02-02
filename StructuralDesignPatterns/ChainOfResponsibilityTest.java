/* 
    We want to simulate money withdrawal from our account using check
    • For Tk. < 10,000 only cashier's authorization is sufficient to withdraw
      money from account.
    • For Tk. 10,000 to 10,00,000 authorization from both cashier and
      senior officer is needed
    • For Tk > 10,00,000 authorization from Senior officer and Manager is
      mandatory.
    • Please implement this behaviour using appropriate software design
      pattern
*/

import java.util.ArrayList;
import java.util.List;

// Request object
class WithdrawalRequest {
    private final long amount;
    private final List<String> approvals = new ArrayList<>();

    public WithdrawalRequest(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void addApproval(String approver) {
        approvals.add(approver);
    }

    public List<String> getApprovals() {
        return approvals;
    }
}

abstract class Approver{
    protected Approver nextApprover;

    public void nextApprover(Approver next){
        this.nextApprover = next;
        
    }

    abstract protected void Approve(WithdrawalRequest request);
}

class Cashier extends Approver{

    @Override
    protected void Approve(WithdrawalRequest request) {
        long amount = request.getAmount();
        if(amount < 10000){
            System.out.println("Approved by Cashier :" + amount + "taka");
            request.addApproval("Cashier");
        }else{
            if(nextApprover != null){
                nextApprover.Approve(request);
            }
        }
    }
}

class SeniorOfficer extends Approver{
    @Override
    protected void Approve(WithdrawalRequest request) {
        long amount = request.getAmount();
        if(amount >= 10000 && amount <= 1000000){
            System.out.println("Approved by Senior Officer :" + amount + "taka");
            request.addApproval("Senior Officer");
        }else{
            if(nextApprover != null){
                nextApprover.Approve(request);
            }
        }
    }
}

class Manager extends Approver{
    @Override
    protected void Approve(WithdrawalRequest request) {
        long amount = request.getAmount();
        if(amount > 1000000){
            System.out.println("Approved by Manager :" + amount + "taka");
            request.addApproval("Manager");
        }else{
            if(nextApprover != null){
                nextApprover.Approve(request);
            }
        }
    }
}

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Approver cashier = new Cashier();
        Approver seniorOfficer = new SeniorOfficer();
        Approver manager = new Manager();

        cashier.nextApprover(seniorOfficer);
        seniorOfficer.nextApprover(manager);

        WithdrawalRequest request1 = new WithdrawalRequest(5000);
        cashier.Approve(request1);

        WithdrawalRequest request2 = new WithdrawalRequest(50000);
        cashier.Approve(request2);

        WithdrawalRequest request3 = new WithdrawalRequest(5000000);
        cashier.Approve(request3);
    }
}

