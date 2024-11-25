using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using RazorPagesRental.Data;
using RazorPagesRental.Models;

namespace RazorPagesRental.Pages_Customers
{
    public class DeleteModel : PageModel
    {
        private readonly RazorPagesRental.Data.RazorPagesCustomersContext _context;

        private readonly RazorPagesRental.Data.RazorPagesRentalsContext __context;

        public DeleteModel(RazorPagesRental.Data.RazorPagesCustomersContext context, RazorPagesRental.Data.RazorPagesRentalsContext contexts)
        {
            _context = context;
            __context = contexts;
        }

        [BindProperty]
        public Customers Customers { get; set; } = default!;

        
        [BindProperty]
        public Rentals Rentals { get; set; } = default!;

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var customers = await _context.Customers.FirstOrDefaultAsync(m => m.Id == id);

            if (customers is not null)
            {
                Customers = customers;

                return Page();
            }

            return NotFound();
        }

        public async Task<IActionResult> OnPostAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var customers = await _context.Customers.FindAsync(id);
            var rentals = await __context.Rentals.FirstOrDefaultAsync(m => m.CustomerId == id);
            if (customers != null || rentals != null)
            {
                Customers = customers;
                _context.Customers.Remove(Customers);
                await _context.SaveChangesAsync();
                 Rentals = rentals;
                __context.Rentals.Remove(Rentals);
                await __context.SaveChangesAsync();
            }

            return RedirectToPage("./Index");
        }
    }
}
